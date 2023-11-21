package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.CategoryEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.category.CategoryReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.CreateCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.DeleteCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.EditCategoryRes;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.GetCategoryRes;
import pe.edu.utp.olimpiadas_aqp.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceInterface {
    
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<GetCategoryRes> getAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<GetCategoryRes> response = new ArrayList<>();
        for (CategoryEntity category : categories) {
            GetCategoryRes categoryRes = new GetCategoryRes();
            BeanUtils.copyProperties(category, categoryRes);
            response.add(categoryRes);
        }
        return response;
    }

    @Override
    public CreateCategoryRes createEvent(CategoryReq categoryReq) {
        CategoryEntity categoryEntity = new CategoryEntity();
        SportEntity sportEntity = new SportEntity();
        CreateCategoryRes response = new CreateCategoryRes();
        GetCategoryRes categoryRes = new GetCategoryRes();
        BeanUtils.copyProperties(categoryReq, categoryEntity);
        sportEntity.setSportId(categoryReq.getSportId());
        categoryEntity.setSport(sportEntity);
        categoryRepository.save(categoryEntity);
        BeanUtils.copyProperties(categoryEntity, categoryRes);
        response.setMessage("Categoría creada correctamente.");
        response.setStatus(201);
        response.setCategory(categoryRes);
        return response;
    }

    @Override
    public EditCategoryRes editCategoryById(Long categoryId, CategoryReq categoryReq) {
        EditCategoryRes response = new EditCategoryRes();
        int isCorrect = categoryRepository.editById(
                categoryId,
                categoryReq.getName(),
                categoryReq.getDescription());
        if (isCorrect == 1) {
            response.setStatus(204);
            response.setMessage("Editado correctamente.");
        } else {
            response.setStatus(400);
            response.setMessage("Error en la edición.");
        }
        return response;
    }

    @Override
    public DeleteCategoryRes deleteCategoryById(Long categoryId) {
        DeleteCategoryRes response = new DeleteCategoryRes();
        categoryRepository.deleteById(categoryId);
        response.setStatus(204);
        response.setMessage("Eliminado correctamente.");
        return response;
    }
}