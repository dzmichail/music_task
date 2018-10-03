package app.service;

import app.dto.CompositionDTO;
import app.dto.ExecutorDTO;
import app.entity.MusicGroup;

public interface IMusicService {
    void saveComp(CompositionDTO cdto);
    void saveExec(ExecutorDTO edto);
    MusicGroup getMusic(Integer id);
}
