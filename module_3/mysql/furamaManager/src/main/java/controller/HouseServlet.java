package controller;

import model.person.Employee;
import service.impl.HouseServiceImpl;
import service.iterface.IHouseService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HouseServlet" ,urlPatterns = {"/house"})
public class HouseServlet extends HttpServlet {

}
