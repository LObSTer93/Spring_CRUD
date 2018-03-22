package service;

import Exceptions.InfoNotFoundException;
import dao.Info;
import dao.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InfoServiceImpl implements InfoService {

    @Autowired
    private Repo repo;

    @Override
    public List<Info> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Info info) {
        repo.save(info);
    }

    @Override
    public void delete(long infoId) {
        repo.delete(infoId);
    }

    @Override
    public Info getById(long infoId) {
        Info info = repo.getById(infoId);
        if(info == null){
            throw new InfoNotFoundException(infoId);
        }
        return info;
    }

    @Override
    public void edit(String name, String email, long id) {

    }
}
