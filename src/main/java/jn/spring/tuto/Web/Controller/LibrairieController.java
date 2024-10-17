package jn.spring.tuto.Web.Controller;

import jn.spring.tuto.Model.Librairie;
import jn.spring.tuto.Service.Imp.LibrairieService;
import jn.spring.tuto.Service.Interface.LibrairieManager;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librairie")
@AllArgsConstructor
public class LibrairieController {
    private final LibrairieManager librairieManager;

    @PostMapping("/create")
    ResponseEntity<Librairie> create(@RequestBody Librairie librairie) {
        Librairie response=librairieManager.createLibrairie(librairie);
        if (response!=null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    ResponseEntity<List<Librairie>> getAll() {
        List<Librairie> response=librairieManager.getAllLibrairies();
        if (response!=null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/get")
    ResponseEntity<Librairie> get(@RequestParam String nom) {
        Librairie response=librairieManager.getLibrairie(nom);
        if (response!=null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete")
    ResponseEntity<String> delete(@RequestParam String nom) {
        String response=librairieManager.deleteLibrairie(nom);
        if (response!=null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/update")
    ResponseEntity<Librairie> update(@RequestParam String nom,@RequestBody Librairie librairie) {
        Librairie response=librairieManager.updateLibrairie(nom,librairie);
        if (response!=null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }
}
