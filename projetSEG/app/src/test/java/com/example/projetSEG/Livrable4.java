package com.example.projetSEG;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.projetSEG.Livrable4;

public class Livrable4 {

    @Test
    public void testRatingObject() {
        Rating rating;
        rating = new Rating(4.5f, "commantaire");
        float rate;
        rate = rating.star;

        assertEquals("testRatingObject", 4.5f, rate, 0.001);
    }

    @Test
    public void test() {

    }
}
