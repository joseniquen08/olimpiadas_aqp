package pe.edu.utp.olimpiadas_aqp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.olimpiadas_aqp.entities.CategoryEntity;
import pe.edu.utp.olimpiadas_aqp.entities.SportEventEntity;
import pe.edu.utp.olimpiadas_aqp.models.requests.category.CategoryReq;
import pe.edu.utp.olimpiadas_aqp.models.responses.category.*;
import pe.edu.utp.olimpiadas_aqp.repositories.CategoryRepository;
import pe.edu.utp.olimpiadas_aqp.repositories.SportEventRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {
    
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SportEventRepository sportEventRepository;

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
    public GetCategoriesBySportEventIdRes getBySportEventId(Long sportEventId) {
        List<CategoryEntity> categoriesRes = categoryRepository.findBySportEventId(sportEventId);
        GetCategoriesBySportEventIdRes response = new GetCategoriesBySportEventIdRes();
        List<GetCategoryRes> categories = new ArrayList<>();
        for (CategoryEntity category : categoriesRes) {
            GetCategoryRes categoryRes = new GetCategoryRes();
            BeanUtils.copyProperties(category, categoryRes);
            categories.add(categoryRes);
        }
        response.setCategories(categories);
        SportEventEntity sportEventEntity;
        Optional<SportEventEntity> findByIdRes = sportEventRepository.findById(sportEventId);
        if (findByIdRes.isPresent()) {
            sportEventEntity = findByIdRes.get();
            response.setEventName(sportEventEntity.getEvent().getName());
            response.setSportName(sportEventEntity.getSport().getName());
        }
        return response;
    }

    @Override
    public CreateCategoryRes createCategory(CategoryReq categoryReq) {
        CategoryEntity categoryEntity = new CategoryEntity();
        SportEventEntity sportEventEntity = new SportEventEntity();
        CreateCategoryRes response = new CreateCategoryRes();
        GetCategoryRes categoryRes = new GetCategoryRes();
        BeanUtils.copyProperties(categoryReq, categoryEntity);
        sportEventEntity.setSportEventId(categoryReq.getSportEventId());
        categoryEntity.setSportEvent(sportEventEntity);
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