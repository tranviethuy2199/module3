package controller;

import model.person.Customer;
import model.person.Employee;
import service.impl.CustomerServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.iterface.IEmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="EmployeeServlet" , urlPatterns = {"/employee" })
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private IEmployeeService cs = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "search":
                    searchEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "search":
                    searchEmployee(request, response);
                    break;
                case "view":
                    viewEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = cs.selectEmployee(id);
        RequestDispatcher dispatcher;
        if (employee == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("employee", employee);
            dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeView.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Boolean employees = cs.deleteEmployee(id);
        RequestDispatcher dispatcher;
        if (false) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else  {
            request.setAttribute("employee" , employees);
            dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeDelete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Employee> employees = null;
        try {
            employees = this.cs.findByName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (employees.size() == 0) {
            request.setAttribute("mess", "Not found");
            try {
                request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("employee", employees);
            try {
                request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Employee> listEmployee = cs.selectAllEmployeePro();
        request.setAttribute("employee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeCreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        Employee employee = cs.selectEmployee(idEdit);
        request.setAttribute("employee",employee);
        request.getRequestDispatcher("/EmployeeView/EmployeeEdit.jsp").forward(request,response);


    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        String cmnd = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int division = Integer.parseInt(request.getParameter("division_id"));
        Employee employee = new Employee(0,name,dateOfBirth,cmnd,email,phone_number,education_degree_id,position_id,division,salary,address);
        cs.insertEmployee(employee);
        request.setAttribute("message" , "New Employee was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeCreate.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idEdit"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        String cmnd = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree_id"));
        int division_id = Integer.parseInt(request.getParameter("division_id"));

        Employee employee = new Employee(id,name,dateOfBirth,cmnd,email,phone_number, position_id,education_degree_id,division_id,salary,address);
        cs.updateEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        cs.deleteEmployeePro(id);
        request.setAttribute("employee", cs.selectAllEmployee());
        request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp").forward(request,response);
    }

}
