CREATE TABLE public.movies (
   id int4 NOT NULL,
   title varchar NOT NULL,
   description varchar NOT NULL,
   release_year int NOT NULL,
   duration numeric(10,2) NOT NULL,
   director varchar NOT NULL,
   status varchar NOT NULL DEFAULT 'AVAILABLE',
   created_date  timestamp(0) NOT NULL,
   updated_date  timestamp(0) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE public.user_favourite_movies (
   id int4 NOT NULL,
   userId int4 NOT NULL,
   movieId int4 NOT NULL,
   PRIMARY KEY (id)
);