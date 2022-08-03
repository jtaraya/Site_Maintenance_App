package models;

import dao.DB;
import dao.Sql2OEngineerDao;
import dao.Sql2OSiteDao;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
//        String layout = "templates/layout.hbs";
        Sql2OSiteDao siteDao = new Sql2OSiteDao(DB.sql2o);
        Sql2OEngineerDao engineerDao = new Sql2OEngineerDao(DB.sql2o);

        ProcessBuilder process = new ProcessBuilder();
        Integer port;


        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4563;
        }
        port(port);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> allEngineers = engineerDao.getAll();
            model.put("engineers", allEngineers);
            List<Site> sites = siteDao.getAll();
            model.put("engineers", allEngineers);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //        get: show new engineer form
        get("/engineers", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> engineers = engineerDao.getAll();
            model.put("engineers", engineers);
            return new ModelAndView(model, "engineer-add-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/engineer/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Engineer> engineers = engineerDao.getAll();
            int emp_no = Integer.parseInt(request.queryParams("emp_no"));
            String name = request.queryParams("name");
            Engineer newEngineer = new Engineer(name, emp_no);
            System.out.println(name);
            engineerDao.add(newEngineer);
//            newEngineer.getEngineerDetails();
            model.put("engineers", engineers);
            return new ModelAndView(model, "/engineer-success.hbs");

        }, new HandlebarsTemplateEngine());

    }
}