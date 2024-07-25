package jerff.devs.FPBE_Aula3.repository;

import jerff.devs.FPBE_Aula3.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query("SELECT c FROM Categoria c JOIN FETCH c.produtos WHERE c.id = :id")
    Categoria findCategoriaComProdutos(@Param("id") Long id);
}