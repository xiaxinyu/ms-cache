package com.sailfish.cache.redis.model;

import lombok.*;

/**
 * @author XIAXINYU3
 * @date 2020/11/30
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
}
