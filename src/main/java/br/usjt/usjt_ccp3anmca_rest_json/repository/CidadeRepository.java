package br.usjt.usjt_ccp3anmca_rest_json.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.usjt.usjt_ccp3anmca_rest_json.model.Cidade;

public interface CidadeRepository extends JpaRepository <Cidade, Long>{
}
