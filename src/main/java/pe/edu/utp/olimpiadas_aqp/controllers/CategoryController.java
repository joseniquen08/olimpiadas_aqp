package pe.edu.utp.olimpiadas_aqp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.utp.olimpiadas_aqp.models.requests.category.CategoryReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.event.DeleteEventRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.CreateCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.DeleteCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.EditCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.GetCategoryRes;
import pe.edu.utp.olimpiadas_aqp.services.CategoryServiceInterface;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryServiceInterface categoryService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<GetCategoryRes> getAll() {
        return categoryService.getAll();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public CreateCategoryRes create(@RequestBody CategoryReq categoryReq) {
        return categoryService.createEvent(categoryReq);
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.PUT)
    public EditCategoryRes editById(@PathVariable("id") Long categoryId, @RequestBody CategoryReq categoryReq) {
        return categoryService.editCategoryById(categoryId, categoryReq);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public DeleteCategoryRes deleteById(@PathVariable("id") Long categoryId) {
        return categoryService.deleteCategoryById(categoryId);
    }
}
