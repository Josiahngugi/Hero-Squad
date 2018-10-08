import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App{
    public static void main(String[] args){
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

//        heroku
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);


//        get method for index
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model , layout);
        }, new VelocityTemplateEngine());


//        get method for collecting all squads created
        get("/categories/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/squad-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

//        post method for creating new squads
        post("/categories", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String dedication=request.queryParams("dedication");
            String size = request.queryParams("size");
            Squad newSquad = new Squad(name,dedication,size);
            model.put("template", "templates/squad-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



//        get method for displaying all new created Squads
        get("/categories", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("categories", Squad.all());
            model.put("template", "templates/squads.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

//        get method for creation of indiviual squad
        get("/categories/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

//        get method for displaying individual hero created
        get("categories/:id/tasks/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad-hero-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


//        post method for displaying all heros added
        post("/tasks", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Squad squad = Squad.find(Integer.parseInt(request.queryParams("categoryId")));

            String description = request.queryParams("description");
            String age=request.queryParams("age");
            String power=request.queryParams("power");
            Task newTask = new Task(description,age,power);

            squad.addTask(newTask);

//            model for success addition of new Hero
            model.put("squad", squad);
            model.put("template", "templates/squad-hero-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


    }
}