package controller;

import model.Employee;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request,response);
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("date");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));

        Employee employee = new Employee(id, name, dayOfBirth, idCard, salary, phone, email, address, position, educationDegree, division);

        boolean check = iEmployeeService.edit(employee);
        Employee newEmployee = iEmployeeService.findEmployeeByID(id);
        request.setAttribute("employee",newEmployee);
        String mess = "Update Employee successfully.";

        if (!check) {
            mess = "Update Employee failed.";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int educationDegree = Integer.parseInt(request.getParameter("education"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(name, dayOfBirth, idCard, salary, phone, email, address, position,
                educationDegree, divisionId);
        boolean check = iEmployeeService.create(employee);
        String mess = "Thêm mới thành công.";
        if (!check) {
            mess = "Thêm mới không thành công";
        }

        request.setAttribute("mess", mess);
        request.setAttribute("check", check);
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "search":
                searchEmployee(request,response);
                break;
            default:
                listEmployee(request,response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = new ArrayList<>();
        String name = request.getParameter("name");
        if(name.equals("")){
            try {
                response.sendRedirect("/employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            employees = iEmployeeService.findEmployeeByName(name);
            request.setAttribute("employeeList",employees);
            try {
                request.getRequestDispatcher("view/employee/list.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int idDelete = Integer.parseInt(request.getParameter("id"));
        boolean check = iEmployeeService.delete(idDelete);
        String mess = "Delete Employee failed.";
        if (check) {
            mess = "Delete Employee successfully.";
        }
        request.setAttribute("mess", mess);
        request.setAttribute("check", check);
        listEmployee(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployeeService.findEmployeeByID(id);
        request.setAttribute("employee",employee);
        try {
            request.getRequestDispatcher("view/employee/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/employee/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
