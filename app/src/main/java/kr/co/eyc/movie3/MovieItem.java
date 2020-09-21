package kr.co.eyc.movie3;

import java.util.ArrayList;

public class MovieItem {

    BoxOffice boxOfficeResult;
}

class BoxOffice{
    String boxofficeType;
    String showRange;
    ArrayList<DaliyBoxofficeList> dailyBoxOfficeList= null;
}

class DaliyBoxofficeList{
    String rnum;
    String rank;
    String rankInten;
    String rankOldAndNew;
    String movieCd;
    String movieNm;
    String openDt;
    String salesAmt;
    String salesShare;
    String salesInten;
    String salesChange;
    String salesAcc;
    String audiCnt;
    String audiInten;
    String audiChange;
    String audiAcc;
    String scrnCnt;
    String showCnt;
}