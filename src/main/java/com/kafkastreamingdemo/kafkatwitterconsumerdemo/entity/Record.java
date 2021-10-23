package com.kafkastreamingdemo.kafkatwitterconsumerdemo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document( collection = "record" )
@FieldDefaults( level = AccessLevel.PRIVATE )
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record implements Serializable {

    @Id
    @JsonProperty( "id" )
    private String id;
    @JsonProperty( "source" )
    private String source;
    @JsonProperty( "in_reply_to_user_id" )
    private String inReplyToUserId;
    @JsonProperty( "lang" )
    private String lang;
    @JsonProperty( "created_at" )
    private String createdAt;
    @JsonProperty( "author_id" )
    private String authorId;
    @JsonProperty( "text" )
    private String text;
}
