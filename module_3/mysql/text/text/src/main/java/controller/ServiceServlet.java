package controller;

import model.Facility;
import service.IFacilityService;
import service.impl.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private static IFacilityService iFacilityService = new FacilityService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String type = request.getParameter("type");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                listService(request,response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/facility/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Facility> facilityList = new ArrayList<>();
        facilityList = iFacilityService.findAll();
        request.setAttribute("facilityList",facilityList);
        try {
            request.getRequestDispatcher("view/facility/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
