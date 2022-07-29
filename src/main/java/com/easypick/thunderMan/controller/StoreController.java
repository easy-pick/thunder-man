package com.easypick.thunderMan.controller;

import com.easypick.thunderMan.dto.DlStoreDto;
import com.easypick.thunderMan.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class StoreController {
	
	@Autowired
	StoreService storeService;
	
	@GetMapping("/store/{category}/{address1}")
	public String store(@PathVariable long category, @PathVariable long address1, Model model) {
		
		List<DlStoreDto> storeList = storeService.storeList(category, address1 / 100);
		log.debug("storeList :::  " + storeList);
		model.addAttribute("storeList", storeList);

		return "store/store";
	}
	
	@GetMapping("/store/{id}/detail")
	public String storeDetail(@PathVariable long id, Model model) {

		DlDto storeDetailDto = storeService.storeDetail(id);

		model.addAttribute("store", storeDetailDto);

		return "store/detail";
	}

	
}
