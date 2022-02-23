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

@WebServlet(name = "DetailsContest", value = "/detailscontest-servlet")
public class DetailsContest extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        ContestDAO contestDAO = new ContestDAO();
        Contest contest = contestDAO.findById(id);
        PlayerDAO playerDAO = new PlayerDAO();
        ArrayList<Player> playersList = (ArrayList<Player>) playerDAO.read();
        request.setAttribute("playerList", playersList);
        request.setAttribute("currentContest", contest);
        request.getRequestDispatcher("detailscontest.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String purpose = req.getParameter("purpose");
        int idContest = Integer.parseInt(req.getParameter("idContest"));
        if(purpose.equals("deleteContestor"))
        {
            System.out.println("fefefe");
            int idToDelete = Integer.parseInt(req.getParameter("idToDelete"));
            ContestDAO contestDAO = new ContestDAO();
            contestDAO.deleteContestor(idToDelete);
        }
        if(purpose.equals("addContestor"))
        {
            int idToAdd = Integer.parseInt(req.getParameter("contestor"));
            System.out.println(idContest);
            System.out.println(idToAdd);
            ContestDAO contestDAO = new ContestDAO();
            contestDAO.addContestor(idToAdd, idContest);
        }
        if(purpose.equals("changeWinner"))
        {
            int idToChange = Integer.parseInt(req.getParameter("winner"));
            ContestDAO contestDAO = new ContestDAO();
            contestDAO.updateWinner(idToChange, idContest);
        }

        resp.sendRedirect(req.getContextPath() + "/detailscontest-servlet?id=" + idContest);
    }
}