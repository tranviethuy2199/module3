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

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean customer = cs.deleteCustomer(id);
        RequestDispatcher dispatcher;
        if (!customer) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else  {
            listCustomer(request,response);
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
        request.setAttribute("customers", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerList.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/CustomerView/CustomerCreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        Customer customer = cs.selectCustomer(idEdit);
        request.setAttribute("customer",customer);
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



}
