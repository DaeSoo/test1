package com.spring.boot.ui.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.ui.constant.CategoryConstant;
import com.spring.boot.ui.entity.CategoryEntity;
import com.spring.boot.ui.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Map<CategoryEntity, List<CategoryEntity>> getCategoryEntity(){
		List<CategoryEntity> menuList = categoryRepository.findAll();
		
		//Parent
		List<CategoryEntity> parentMenuList = menuList.stream()
				.filter(category -> category.getIdParent() == CategoryConstant.PARENT_ROOT)
				.collect(Collectors.toList());
		
		Map<Long, List<CategoryEntity>> childMenuMap = menuList.stream()
				.filter(category -> category.getIdParent() != CategoryConstant.PARENT_ROOT)
				.collect(Collectors.groupingBy(CategoryEntity::getIdParent));
        // TreeMenu
        Map<CategoryEntity, List<CategoryEntity>> menuMap = new HashMap<>();
        for(CategoryEntity parent : parentMenuList){
            Long id = parent.getCategoryId();
            List<CategoryEntity> child = childMenuMap.get(id);
            menuMap.put(parent, child);
        }
        Map<CategoryEntity, List<CategoryEntity>> sortedMenuMap = 
            menuMap.entrySet().stream()
            .sorted((e1, e2)-> e1.getKey().getCategoryId().compareTo(e2.getKey().getCategoryId()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return sortedMenuMap;
		
	}


}
