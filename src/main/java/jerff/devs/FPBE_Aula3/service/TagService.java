package jerff.devs.FPBE_Aula3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jerff.devs.FPBE_Aula3.model.Tag;
import jerff.devs.FPBE_Aula3.repository.TagRepository;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> listarTags() {
        return tagRepository.findAll();
    }

    public Tag salvarTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag obterTagPorId(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        return tag.orElse(null);
    }

    public void deletarTag(Long id) {
        tagRepository.deleteById(id);
    }
}