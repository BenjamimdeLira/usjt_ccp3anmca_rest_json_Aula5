package br.usjt.usjt_ccp3anmca_rest_json.resource;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.usjt.usjt_ccp3anmca_rest_json.model.Cidade;
import br.usjt.usjt_ccp3anmca_rest_json.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	@Autowired
	private CidadeRepository cidadeRepo;

	@GetMapping("/lista")
	public List todasAsCidades() {
		return (List) cidadeRepo.findAll();
	}
	
	@PostMapping("/salvar")
	// @ResponseStatus (HttpStatus.CREATED)
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade l = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/{id}").buildAndExpand(l.getId())
				.toUri();
		// response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(l);
	}
	
	@GetMapping ("/{id}")
	public Cidade buscarPeloId (@PathVariable Long id) {
	return cidadeRepo.getOne(id);
	}
	
	@GetMapping ("/{latitude}")
	public Cidade buscarPelaLatitude (@PathVariable int latitude) {
	return cidadeRepo.getOne((long) latitude);
	}
	
	@GetMapping ("/{longitude}")
	public Cidade buscarPelaLongitude (@PathVariable int longitude) {
	return cidadeRepo.getOne((long) longitude);
	}

}
