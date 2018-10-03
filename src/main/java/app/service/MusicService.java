package app.service;

import app.dto.CompositionDTO;
import app.dto.ExecutorDTO;
import app.entity.Composition;
import app.entity.Executor;
import app.entity.MusicGroup;
import app.repository.CompositionRepository;
import app.repository.ExecutorRepository;
import app.repository.MusicGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class MusicService implements IMusicService {

    private CompositionRepository compositionRepository;
    private ExecutorRepository executorRepository;
    private MusicGroupRepository musicGroupRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public MusicService(CompositionRepository compositionRepository, ExecutorRepository executorRepository, MusicGroupRepository musicGroupRepository){
        this.compositionRepository=compositionRepository;
        this.executorRepository=executorRepository;
        this.musicGroupRepository=musicGroupRepository;
    }

    public void saveComp(CompositionDTO cdto){

        Composition comp = new Composition();

        comp.setDuration(cdto.getDuration());
        comp.setName(cdto.getName());

        compositionRepository.save(comp);
    }

    public void saveExec(ExecutorDTO edto){
        System.out.println("LINE 39");
        Executor executor = new Executor();
//        MusicGroup musicGroup  = new MusicGroup();

        MusicGroup musicGroup=musicGroupRepository.getOne(edto.getMusicGroupId());
        System.out.println("LINE 44" + musicGroup.getName());

        if (musicGroup!=null){
            executor.setName(edto.getName());
            executor.setSurname(edto.getSurname());
            executor.setPatronymic(edto.getPatronymic());
            executor.setSex(edto.getSex());
            executor.setRole(edto.getRole());
            executor.setMusicGroup(musicGroup);

            System.out.println("LINE 52");

            executorRepository.save(executor);
        }
    }

    public MusicGroup getMusic(Integer id){
//        return musicGroupRepository.getOne(id);
        return entityManager.find(MusicGroup.class, id);
    }


}
