package com.mlsolucoes.envelope.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mlsolucoes.envelope.exception.InsumoJaExiste;
import com.mlsolucoes.envelope.filter.ConsumoFilter;
import com.mlsolucoes.envelope.filter.InsumoFilter;
import com.mlsolucoes.envelope.model.Insumo;
import com.mlsolucoes.envelope.repository.ConsumoRepository;
import com.mlsolucoes.envelope.services.WebServices;

@RestController
@RequestMapping
public class Controller {

	@Autowired
	private WebServices services;

	@Autowired
	private ConsumoRepository consumoRepository;

	@GetMapping("/insumo/novo")
	public ModelAndView novo(Insumo insumo) {
		ModelAndView mv = new ModelAndView("cadastroInsumo");

		mv.addObject("comboColor", services.getAllColor());
		mv.addObject("comboGramatura", services.getAllGramatura());
		mv.addObject("comboTamanho", services.getAllTamanho());
		mv.addObject("comboImpressao", services.getAllImpressao());

		return mv;
	}

	@PostMapping("/insumo/novo")
	public ModelAndView salvarInsumo(@Valid Insumo insumo, BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors())
			return novo(insumo);

		try {
			insumo = services.saveInsumo(insumo);
		} catch (InsumoJaExiste e) {
			result.rejectValue("codigo", null, e.getMensagem());
			return novo(insumo);
		}
		attr.addFlashAttribute("mensagem", String.format("Id {%s} salva com sucesso!", insumo.getId()));
		return new ModelAndView("redirect:/insumo/novo");
	}

	@GetMapping("/insumo")
	public ModelAndView pesquisa(InsumoFilter insumoFilter) {
		ModelAndView mv = new ModelAndView("pesquisaInsumo");
		if (StringUtils.isEmpty(insumoFilter.getCodigo())) {
			mv.addObject("listaInsumo", services.pesquisarInsumo());
		} else {
			Optional<Insumo> insumo = services.pesquisarInsumo(insumoFilter.getCodigo());
			if (insumo.isPresent())
				mv.addObject("listaInsumo", Arrays.asList(insumo.get()));
		}
		mv.addObject(insumoFilter);

//		try {
//			List<Insumo> collect = Files.lines(Paths.get("/tmp/codigos.txt"), StandardCharsets.UTF_8)
//					.map(l -> new Insumo(l.split("\t")[0], l.split("\t")[1])).collect(Collectors.toList());
//
//			collect.forEach(i -> {
//				Optional<Insumo> pesquisarInsumo = services.pesquisarInsumo(i.getCodigo());
//				if(pesquisarInsumo.isPresent()) {
//					pesquisarInsumo.get().setDescricao(i.getDescricao());
//					
//					services.saveInsumo(pesquisarInsumo.get());
//				}
//			});
//
//			// services.saveList(collect);
//		} catch (IOException e) {
//		}

//		try {
//			final List<Insumo> insumos = services.pesquisarInsumo();
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			sdf.setLenient(true);
//
//			List<Consumo> collect = Files.lines(Paths.get("/tmp/consumo.txt"), StandardCharsets.UTF_8).skip(2).map(l -> {
//				String parans[] = l.split("\t");
//
//				Optional<Insumo> insumo = insumos.parallelStream().filter(i -> i.getCodigo().equals(parans[0]))
//						.findAny();
//
//				Consumo consumo = new Consumo();
//				consumo.setTipoMaterial(TipoMaterial.Envelope);
//				consumo.setInsumo(insumo.get());
//				try {
//					consumo.setEntradaNotaFiscal(sdf.parse(parans[1]));
//				} catch (Exception e) {
//				}
//				consumo.setQtdFornecido(new BigDecimal(parans[2].trim().replace(".", "").replace(",", ".")));
//				consumo.setValorTotal(new BigDecimal(parans[3].trim().replace(".", "").replace(",", ".")));
//				return consumo;
//			}).collect(Collectors.toList());
//
//			consumoRepository.saveAll(collect);
//			System.out.println("fim");
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}

		return mv;
	}

	@GetMapping("/insumo/{id}")
	public ModelAndView pesquisaId(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("cadastroInsumo");

		if (id != null) {
			Optional<Insumo> insumo = services.pesquisarInsumo(id);
			if (insumo.isPresent()) {
				mv = novo(insumo.get());
				mv.addObject(insumo.get());
				return mv;
			}
		}
		mv.addObject(new Insumo());
		mv.addObject("erro", String.format("Entidade {%s} não localizada.", id));
		return mv;
	}

	@GetMapping(value = "/insumo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Insumo> pesquisarAjax() {
		return services.pesquisarInsumo();
	}

	@GetMapping("/")
	public ModelAndView pesquisaConsumo(ConsumoFilter consumoFilter) {
		ModelAndView mv = new ModelAndView("pesquisaConsumo");

		mv.addObject("comboColor", services.getAllColor());
		mv.addObject("comboGramatura", services.getAllGramatura());
		mv.addObject("comboTamanho", services.getAllTamanho());
		
		mv.addObject("listaConsumo", services.pesquisarConsumo(consumoFilter));

		return mv;
	}
}
