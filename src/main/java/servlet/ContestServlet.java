package servlet;

import dao.ContestDAO;
import dao.GameDAO;
import dao.PlayerDAO;
import model.Contest;
import model.Game;
import model.Player;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ContestServlet", value = "/contest-servlet")
public class ContestServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        GameDAO gameDAO = new GameDAO();
        ArrayList<Game> gameList = (ArrayList<Game>) gameDAO.read();
        request.setAttribute("gameList", gameList);
        PlayerDAO playerDAO = new PlayerDAO();
        ArrayList<Player> playersList = (ArrayList<Player>) playerDAO.read();
        request.setAttribute("playersList", playersList);

        request.getRequestDispatcher("contest.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int game = Integer.parseInt(req.getParameter("game"));
        System.out.println(game);
        Date date = Date.valueOf(req.getParameter("date"));
        System.out.println(date);
        ContestDAO contestDAO = new ContestDAO();
        Contest contest = new Contest(game, date);
        contestDAO.create(contest);
        resp.sendRedirect(req.getContextPath() + "/contest-servlet");
    }
}