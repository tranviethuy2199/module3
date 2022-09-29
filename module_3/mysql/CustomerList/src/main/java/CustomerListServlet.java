import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerListServlet" , urlPatterns = "")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "văn A", "1999-01-01", "Hà Nội" ,"img/7a94e2aaa7cd0fcdc35eae3178425243.jpg" ));
        customers.add(new Customer(2, "văn B", "1983-01-02", "Hà Nội","img/75315db511a058432745fc37d82a7c44.jpg"));
        customers.add(new Customer(3, "văn C", "1983-01-03", "Hà Nội","img/base64-1630338891705886790432.webp"));
        customers.add(new Customer(4, "văn D", "1983-01-04", "Hà Tây","img/cca2417a7668673ce24e4ae458f46625.jpg"));
        customers.add(new Customer(5, "văn E", "1983-01-05", "Hà Nội","img/7a94e2aaa7cd0fcdc35eae3178425243.jpg"));
        request.setAttribute("customerListServlet", customers);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
