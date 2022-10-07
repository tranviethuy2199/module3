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

//    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
//        Customer customer = new Customer( 1, "minh châu" , "2000-02-02","0","321654987","0905468651","chau@gmail.com","đà nẵng");
//        int[] permision = {1, 2, 4};
//        cs.addCustomerTransaction(customer, permision);
//    }

    //    private void sort(HttpServletRequest request, HttpServletResponse response) {
//        String sortByName = request.getParameter("sortByName");
//        try {
//            List<User> users = userDAO.sort(sortByName);
//            request.setAttribute("listUser" , users);
//            request.setAttribute("mess" , "is was sorted");
//            request.getRequestDispatcher("user/list.jsp").forward(request,response);
//        } catch (SQLException | ServletException | IOException throwables) {
//            throwables.printStackTrace();
//        }
//    }
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
            dispatcher = request.getRequestDispatcher("/EmployeerView/EmployeeDelete.jsp");
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

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idEdit",idEdit);
        request.getRequestDispatcher("/EmployeeView/EmployeeEdit.jsp").forward(request,response);


    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String cmnd = request.getParameter("cmnd");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        int education_degree = Integer.parseInt(request.getParameter("education_degree"));
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int division = Integer.parseInt(request.getParameter("division"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        Employee employee = new Employee(0,name,dayOfBirth,cmnd,email,phone_number,education_degree,position_id,division,salary,address);
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
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String cmnd = request.getParameter("cmnd");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        int education_degree = Integer.parseInt(request.getParameter("education_degree"));
        int position_id = Integer.parseInt(request.getParameter("position_id"));
        int division = Integer.parseInt(request.getParameter("division"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        Employee employee = new Employee(id,name,dayOfBirth,cmnd,email,phone_number,education_degree,position_id,division,salary,address);
        cs.updateEmployee(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        cs.deleteEmployeePro(id);
        List<Employee> employeeList = cs.selectAllEmployee();
        request.setAttribute("customer", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp");
        dispatcher.forward(request, response);
    }
//    private IEmployeeService employeeService = new EmployeeServiceImpl();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createEmployee(request, response);
//                break;
//            case "edit":
//                updateEmployee(request, response);
//                break;
//            case "delete":
//                deleteEmployee(request, response);
//                break;
//            case "search":
//                searchEmployee(request, response);
//                break;
//            default:
//                listEmployee(request,response);
//                break;
//        }
//    }
//
//    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        String name = request.getParameter("search");
//        List<Employee> employees = this.employeeService.findByName(name);
//        if (employees.size() == 0) {
//            request.setAttribute("message", "Not found anybody");
//            try {
//                request.getRequestDispatcher("EmployeeView/EmployeeSearch.jsp").forward(request, response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            request.setAttribute("employee", employees);
//            try {
//                request.getRequestDispatcher("EmployeeView/EmployeeSearch.jsp").forward(request, response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee employee = this.employeeService.(id);
//        RequestDispatcher dispatcher;
//        if (employee == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            this.employeeService.remove(id);
//            try {
//                response.sendRedirect("/employee");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String dayOfBirth = request.getParameter("dayOfBirth");
//        String cmnd = request.getParameter("cmnd");
//        String email = request.getParameter("email");
//        Employee employee = this.employeeService.findById(id);
//        RequestDispatcher dispatcher;
//        if (employee == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            employee.setName(name);
//            employee.setCmnd(cmnd);
//            employee.setDayOfBirth(dayOfBirth);
//            employee.setEmail(email);
//            this.employeeService.update(employee);
//            request.setAttribute("employee", employee);
//            request.setAttribute("messaage", "employee information was update");
//            dispatcher = request.getRequestDispatcher("EmployeeEdit.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
//        int id = (int) (Math.random() * 1000);
//        String name = request.getParameter("name");
//        String dayOfBirth = request.getParameter("dayOfBirth");
//        String cmnd = request.getParameter("cmnd");
//        String email = request.getParameter("email");
//        String gender = request.getParameter("gender");
//        String education_degree = request.getParameter("education_degree");
//        String position_id = request.getParameter("position_id");
//        String salary = request.getParameter("salary");
//
//        Employee employee = new Employee(id, name, dayOfBirth, cmnd, email,gender,education_degree,position_id,salary);
//        this.employeeService.save(employee);
//        request.setAttribute("message", "New employee was created");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeView/EmployeeCreate.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                showCreateForm(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "delete":
//                showDeleteForm(request, response);
//                break;
//            case "search":
//                searchEmployee(request, response);
//                break;
//            case "view":
//                viewEmployee(request, response);
//                break;
//            default:
//                listEmployee(request, response);
//                break;
//        }
//    }
//
//    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Employee> employees = this.employeeService.findAll();
//        request.setAttribute("employee", employees);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeView/EmployeeList.jsp");
//        dispatcher.forward(request, response);
//
//    }
//
//
//    private void viewEmployee(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee employee = this.employeeService.findById(id);
//        RequestDispatcher dispatcher;
//        if (employee == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else {
//            request.setAttribute("employee", employee);
//            dispatcher = request.getRequestDispatcher("EmployeeView/EmployeeView.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee employee = this.employeeService.findById(id);
//        RequestDispatcher dispatcher;
//        if (employee == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else  {
//            request.setAttribute("employee" , employee);
//            dispatcher = request.getRequestDispatcher("EmployeeView/EmployeeDelete.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Employee employee = this.employeeService.findById(id);
//        RequestDispatcher dispatcher;
//        if(employee == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            request.setAttribute("employee" , employee);
//            dispatcher = request.getRequestDispatcher("EmployeeView/EmployeeEdit.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeView/EmployeeCreate.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
