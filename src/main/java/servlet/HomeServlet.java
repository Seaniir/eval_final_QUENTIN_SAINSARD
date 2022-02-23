package servlet;

import dao.ContestDAO;
import dao.GameDAO;
import dao.PlayerDAO;
import model.Contest;
import model.Game;
import model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HomeServlet", value = "/home-servlet")
public class HomeServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        GameDAO gameDAO = new GameDAO();
        PlayerDAO playerDAO = new PlayerDAO();
        ContestDAO contestDAO = new ContestDAO();
        ArrayList<Game> gameList = (ArrayList<Game>) gameDAO.read();
        ArrayList<Player> playersList = (ArrayList<Player>) playerDAO.read();
        ArrayList<Contest> contestList = (ArrayList<Contest>) contestDAO.read();
        request.setAttribute("gameList", gameList);
        request.setAttribute("playersList", playersList);
        request.setAttribute("contestList", contestList);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}