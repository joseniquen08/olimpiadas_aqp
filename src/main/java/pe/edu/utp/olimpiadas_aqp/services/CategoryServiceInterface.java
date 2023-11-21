package pe.edu.utp.olimpiadas_aqp.services;
import pe.edu.utp.olimpiadas_aqp.models.requests.category.CategoryReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.CreateCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.DeleteCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.EditCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.GetCategoryRes;

import java.util.List;

public interface CategoryServiceInterface {
    List<GetCategoryRes> getAll();
    CreateCategoryRes createEvent(CategoryReq categoryReq);

    EditCategoryRes editCategoryById(Long categoryId, CategoryReq categoryReq);
    DeleteCategoryRes deleteCategoryById(Long categoryId);
}
