package com.company.Vamp.viewModels;

import com.company.Vamp.models.Likes;
import java.util.List;
import java.util.ArrayList;

public class LikesView {
    List<Likes> likes = new ArrayList<>();

    public LikesView() {
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setEvents(List<Likes> events) {
        this.likes = likes;
    }

    public LikesView(List<Likes> events) {
        this.likes = likes;
    }

}
