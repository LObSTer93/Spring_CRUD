package Data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoImpl implements Repo {
    @Override
    public List<Info> getInfo() {
        Info info1 = Info.builder()
                .id(1)
                .name("Mike")
                .eMail("Mike@nike.com")
        .build();
        List<Info> infoList = new ArrayList<>();
        infoList.add(info1);

        return infoList;
//        return null;
    }
}
