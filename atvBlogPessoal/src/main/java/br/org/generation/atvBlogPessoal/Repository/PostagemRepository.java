package br.org.generation.atvBlogPessoal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.atvBlogPessoal.model.AtvBlogPessoalModel;

@Repository
public interface PostagemRepository extends JpaRepository<AtvBlogPessoalModel, Long>{

}
