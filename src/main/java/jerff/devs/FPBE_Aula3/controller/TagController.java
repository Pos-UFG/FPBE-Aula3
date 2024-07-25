package jerff.devs.FPBE_Aula3.controller;

import java.util.List;

import jerff.devs.FPBE_Aula3.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jerff.devs.FPBE_Aula3.service.TagService;

@RestController
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public List<Tag> listarTags() {
        return tagService.listarTags();
    }

    @PostMapping
    public Tag adicionarTag(@RequestBody Tag tag) {
        return tagService.salvarTag(tag);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> obterTag(@PathVariable Long id) {
        Tag tag = tagService.obterTagPorId(id);
        if (tag != null) {
            return ResponseEntity.ok(tag);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> editarTag(@PathVariable Long id, @RequestBody jerff.devs.FPBE_Aula3.model.Tag tagDetalhes) {
       Tag tag = tagService.obterTagPorId(id);
        if (tag != null) {
            tag.setNome(tagDetalhes.getNome());
            return ResponseEntity.ok(tagService.salvarTag(tag));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTag(@PathVariable Long id) {
        tagService.deletarTag(id);
        return ResponseEntity.noContent().build();
    }
}