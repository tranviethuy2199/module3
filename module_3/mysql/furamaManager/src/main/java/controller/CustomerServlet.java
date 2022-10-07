package controller;

import model.person.Customer;
import service.impl.CustomerServiceImpl;
import service.iterface.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet" ,urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ICustomerService cs = new CustomerServiceImpl() ;


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
                    insertCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                break;
            case "search":
                    searchCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
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
                searchCustomer(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
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
    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = cs.selectCustomer(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("/CustomerView/CustomerView.jsp");
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
        boolean customer = cs.deleteCustomer(id);
        RequestDispatcher dispatcher;
        if (false) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else  {
            request.setAttribute("customer" , customer);
            dispatcher = request.getRequestDispatcher("/CustomerView/CustomerDelete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("search");
        List<Customer> customers = null;
        try {
            customers = this.cs.findByName(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (customers.size() == 0) {
            request.setAttribute("mess", "Not found");
            try {
                request.getRequestDispatcher("/CustomerView/CustomerList.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("customer", customers);
            try {
                request.getRequestDispatcher("/CustomerView/CustomerList.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<Customer> listCustomer = cs.selectAllCustomerPro();
        request.setAttribute("customer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerList.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerCreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("idEdit",idEdit);
        request.getRequestDispatcher("/CustomerView/CustomerEdit.jsp").forward(request,response);

    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        String cmnd = request.getParameter("id_card");
        String email = request.getParameter("email");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phone_number = request.getParameter("phone_number");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String address = request.getParameter("address");
        Customer customer = new Customer(0,name,dateOfBirth,cmnd,email,gender,phone_number,customer_type_id,address);
        cs.insertCustomer(customer);
        request.setAttribute("message" ,"New Customer was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerCreate.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("idEdit"));
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String cmnd = request.getParameter("id_card");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        Customer newCustomer = new Customer(id,name,dateOfBirth,cmnd,email,gender,phone_number,customer_type_id,address);
        cs.updateCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerList.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        cs.deleteCustomerPro(id);
        List<Customer> listCustomer = cs.selectAllCustomer();
        request.setAttribute("customer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerList.jsp");
        dispatcher.forward(request, response);
    }

//    private ICustomerService customerService = new CustomerServiceImpl();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createCustomer(request, response);
//                break;
//            case "edit":
//                updateCustomer(request, response);
//                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;
//            case "search":
//                searchCustomer(request, response);
//                break;
//            default:
//                break;
//        }
//    }
//
//    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("search");
//        List<Customer> customers = this.customerService.findByName(name);
//        if (customers.size() == 0) {
//            request.setAttribute("message", "Not found anybody");
//            try {
//                request.getRequestDispatcher("/CustomerView/CustomerSearch.jsp").forward(request, response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            request.setAttribute("customer", customers);
//            try {
//                request.getRequestDispatcher("/CustomerView/CustomerSearch.jsp").forward(request, response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            this.customerService.remove(id);
//            try {
//                response.sendRedirect("/customer");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String dayOfBirth = request.getParameter("dayOfBirth");
//        String cmnd = request.getParameter("cmnd");
//        String email = request.getParameter("email");
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            customer.setName(name);
//            customer.setCmnd(cmnd);
//            customer.setDayOfBirth(dayOfBirth);
//            customer.setEmail(email);
//            this.customerService.update(customer);
//            request.setAttribute("customer", customer);
//            request.setAttribute("messaage", "Customer information was update");
//            dispatcher = request.getRequestDispatcher("/CustomerView/CustomerEdit.jsp");
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
//    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = (int) (Math.random() * 1000);
//        String name = request.getParameter("name");
//        String dayOfBirth = request.getParameter("dayOfBirth");
//        String cmnd = request.getParameter("cmnd");
//        String email = request.getParameter("email");
//        String gender =request.getParameter("gender");
//        String customer_type = request.getParameter("customer_type");
//        String address = request.getParameter("address");
//
//        Customer customer = new Customer(id, name, dayOfBirth, cmnd, email ,gender, customer_type , address);
//
//
//        this.customerService.save(customer);
//        request.setAttribute("message", "New Customer was created");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerCreate.jsp");
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
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
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
//                searchCustomer(request, response);
//                break;
//            case "view":
//                viewCustomer(request, response);
//                break;
//            default:
//                listCustomer(request, response);
//                break;
//        }
//    }
//
//    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Customer> customers = this.customerService.findAll();
//        request.setAttribute("customer", customers);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerList.jsp");
//        dispatcher.forward(request, response);
//
//    }
//
//
//    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else {
//            request.setAttribute("customer", customer);
//            dispatcher = request.getRequestDispatcher("/CustomerView/CustomerView.jsp");
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
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if (customer == null) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else  {
//            request.setAttribute("customer" , customer);
//            dispatcher = request.getRequestDispatcher("/CustomerView/CustomerDelete.jsp");
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
//        Customer customer = this.customerService.findById(id);
//        RequestDispatcher dispatcher;
//        if(customer == null){
//            dispatcher = request.getRequestDispatcher("/CustomerView/error-404.jsp");
//        } else {
//            request.setAttribute("customer" , customer);
//            dispatcher = request.getRequestDispatcher("/CustomerView/CustomerEdit.jsp");
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
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerCreate.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
