package service;

import dao.Info;

import java.util.List;

public interface InfoService {

    List<Info> findAll();

    void save(Info info);

    void delete(long infoId);

    Info getById(long infoId);

    void edit(String name, String email, long id);
}