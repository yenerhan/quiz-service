package com.yener.quiz.dto.quiz;

import java.util.List;

public class QestionClobDTO {

    private List<QestionDTO> qestionDTOList;

    public QestionClobDTO() {
    }

    public QestionClobDTO(List<QestionDTO> qestionDTOList) {
        this.qestionDTOList = qestionDTOList;
    }

    public List<QestionDTO> getQestionDTOList() {
        return qestionDTOList;
    }

    public void setQestionDTOList(List<QestionDTO> qestionDTOList) {
        this.qestionDTOList = qestionDTOList;
    }


}
