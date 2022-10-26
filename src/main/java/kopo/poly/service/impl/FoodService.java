package kopo.poly.service.impl;

import kopo.poly.dto.FoodDTO;
import kopo.poly.service.IFoodService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service("FoodService")
public class FoodService implements IFoodService {
    @Override
    public List<FoodDTO> toDayFood() throws Exception {

        //로그 찍기(추후 찍은 로그를 통해 이 함수에 접근했는지 파악하기 용이하다.)
        log.info(this.getClass().getName() + ".toDayFood Start!");

        int res = 0; //크롤링 결과 (0보다 크면 크롤링 성공)

        //서울 강서 캠퍼스 식단 정보 가져올 사이트 주소
        String url = "https://www.kopo.ac.kr/kangseo/content.do?menu=262";

        //JSOUP 라이브러리를 통해 사이트 접속되면, 그 사이트의 전체 html소스 저장할 변수
        Document doc = null;

        //사이트 접속(http프로토콜만 가능, https 프로토콜은 보안상 안됨)
        doc = Jsoup.connect(url).get();

        Elements element = doc.select("table.tbl_table tbody");

        Iterator<Element> foodIt = element.select("tr").iterator();

        FoodDTO pDTO = null;

        List<FoodDTO> pList = new ArrayList<>();
        int idx = 0; //반복횟수를 월요일부터 금요일 까지만 되도록함 (5일만)

        while  (foodIt.hasNext()) {

            if (idx++ > 4) {
                break;
            }


            pDTO = new FoodDTO();

            String food = CmmUtil.nvl(foodIt.next().text().trim());

            log.info("food : " + food);

            pDTO.setDay(food.substring(0,3));


            pDTO.setFood_nm(food.substring(4));

            pList.add(pDTO);
        }

        log.info(this.getClass().getName() + ".toDaFood end");

        return  pList;


    }
}
