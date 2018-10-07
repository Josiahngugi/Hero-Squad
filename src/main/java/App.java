import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App{
    public static void main(String[] args){
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

//        get method for index
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model , layout);
        }, new VelocityTemplateEngine());


//        get method for collecting all squads created
        get("/categories/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/category-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/categories", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String dedication=request.queryParams("dedication");
            String size = request.queryParams("size");
            Category newCategory = new Category(name,dedication,size);
            model.put("template", "templates/category-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



        get("/categories", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("categories", Category.all());
            model.put("template", "templates/categories.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/categories/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Category category = Category.find(Integer.parseInt(request.params(":id")));
            model.put("category", category);
            model.put("template", "templates/category.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("categories/:id/tasks/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Category category = Category.find(Integer.parseInt(request.params(":id")));
            model.put("category", category);
            model.put("template", "templates/category-tasks-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/tasks", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));

            String description = request.queryParams("description");
            String age=request.queryParams("age");
            String power=request.queryParams("power");
            Task newTask = new Task(description,age,power);

            category.addTask(newTask);

            model.put("category", category);
            model.put("template", "templates/category-tasks-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


    }
}