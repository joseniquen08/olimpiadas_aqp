package pe.edu.utp.olimpiadas_aqp.services;
import pe.edu.utp.olimpiadas_aqp.models.requests.category.CategoryReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.*;

import java.util.List;

public interface CategoryServiceInterface {
    List<GetCategoryRes> getAll();
    GetCategoriesBySportEventIdRes getBySportEventId(Long sportEventId);
    CreateCategoryRes createCategory(CategoryReq categoryReq);
    EditCategoryRes editCategoryById(Long categoryId, CategoryReq categoryReq);
    DeleteCategoryRes deleteCategoryById(Long categoryId);
}
