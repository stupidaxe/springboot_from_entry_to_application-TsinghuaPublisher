package com.ch.cardmis.service;

import com.ch.cardmis.entity.CardEntity;
import com.ch.cardmis.entity.UserEntity;
import com.ch.cardmis.repository.CardRepository;
import com.ch.cardmis.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Override
    public String add(CardEntity cardEntity, HttpSession session, MultipartFile file) {
        if("noLogin".equals(isLogin(session))){
            return "noLogin";
        }else{
            UserEntity user = (UserEntity)session.getAttribute("user");
            cardEntity.setUser(user);
            //防止文件名重名
            String newFileName = "";
            if(file != null){
                String fileName = file.getOriginalFilename();
                newFileName = MyUtil.getNewFileName(fileName);
                String realpath = "C:\\Users\\ChenHeng\\IdeaProjects\\cardmis-vue\\cardmis-vue\\static";
                File targetFile = new File(realpath, newFileName);
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
                //设置文件名
                cardEntity.setLogo("static/" + newFileName);
                //上传
                try {
                    file.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            cardRepository.save(cardEntity);
            return "ok";
        }
    }
    @Override
    public Object cards(HttpSession session) {
        if("noLogin".equals(isLogin(session))){
            return "noLogin";
        }else {
            Sort sort = new Sort(Sort.Direction.DESC, "id");
            UserEntity user = (UserEntity)session.getAttribute("user");
            return cardRepository.findByUser_id(user.getId(), sort);
        }
    }
    @Override
    public String delete(HttpSession session,Integer cid) {
        if("noLogin".equals(isLogin(session))){
            return "noLogin";
        }else {
            cardRepository.deleteById(cid);
            return "ok";
        }
    }
    @Override
    public Object aCard(HttpSession session, Integer cid) {
        if("noLogin".equals(isLogin(session))){
            return "noLogin";
        }else {
            return cardRepository.getOne(cid);
        }
    }
    @Override
    public String isLogin(HttpSession session) {
        Object user = session.getAttribute("user");
        if(user == null)
            return "noLogin";
        return "yes";
    }


}
