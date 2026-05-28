package es.uah.serverFilmAffinity2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.uah.serverFilmAffinity2.model.Director;
import es.uah.serverFilmAffinity2.DAO.DirectorRepo;
import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepo directorRepo;

    public List<Director> findAll(){
        return directorRepo.findAll();
    }

    public Director findById(Integer id){
        return directorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("actor id not found " + id));
    }

    public Director findByNombre(String nombre){
        return directorRepo.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("actor name not found " + nombre));
    }

    public Director save(Director director){
        if(director == null){
            throw new IllegalArgumentException("Director object cannot be null");
        }
        if(director.getNombre() == null){
            throw new IllegalArgumentException("Director name cannot be null");
        }
        return directorRepo.save(director);
    }

    public Director updateDirector(Integer id, Director director){
        if(id == null){
            throw new IllegalArgumentException("Director id cannot be null");
        }
        if(director == null){
            throw new IllegalArgumentException("Director name cannot be null");
        }

        // check for existing director
        Director existing = directorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("director id not found " + id));

        // only overwrite sent fields
        if(existing.getNombre() != null){
            existing.setNombre(director.getNombre());
        }

        if(existing.getFechaNacimiento() != null){
            existing.setFechaNacimiento(director.getFechaNacimiento());
        }

        if(existing.getPeliculas() != null){
            existing.setPeliculas(director.getPeliculas());
        }

        return directorRepo.save(existing);
    }

    public boolean deleteById(Integer id){
        if(id == null){
            throw new IllegalArgumentException("Director id cannot be null");
        }
        if(!directorRepo.existsById(id)){
            return false;
        }
        directorRepo.deleteById(id);
        return true;
    }


}
