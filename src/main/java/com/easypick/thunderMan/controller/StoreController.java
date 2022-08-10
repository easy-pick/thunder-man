package com.easypick.thunderMan.controller;

import com.easypick.thunderMan.dto.response.StoreResponse;
import com.easypick.thunderMan.dto.response.StoreWithFoodsResponse;
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
	
	@GetMapping("/store/{category}/{address1}/{page}")
	public String store(@PathVariable long category, @PathVariable long address1, @PathVariable int page, Model model) {

		log.debug("parameter check : category = {}, address1 = {}, page = {} ", category, address1, page);

		List<StoreResponse> storeList = storeService.storeList(category, address1 / 100).map(StoreResponse::from).toList();
		log.debug("return values check : List<StoreResponse> = {} ", storeList);

		model.addAttribute("storeList", storeList);

		return "store/store";
	}
	
	@GetMapping("/store/{id}/detail")
	public String storeDetail(@PathVariable long id, Model model) {

		log.debug("parameter value check : id = {} ", id);

		StoreWithFoodsResponse storeDetailDto = StoreWithFoodsResponse.from(storeService.storeDetail(id));
		log.debug("return value check : StoreWithFoodsResponse = {}", storeDetailDto);

		model.addAttribute("store", storeDetailDto);

		return "store/detail";
	}

	
}
