package xws.microservice.auth.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserPageDTO {

    private List<UserDTO> content;
    private int pageNo;
    private int totalPages;

    public UserPageDTO() {
        content = new ArrayList<UserDTO>();
    }

    public List<UserDTO> getContent() {
        return content;
    }

    public void setContent(List<UserDTO> content) {
        this.content = content;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
