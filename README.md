# meetme
MeetMe uygulaması için gerekli olan back end 'in alt yapı kısmı bu şekilde / buna benzer olacaktır. Bunun üstünden de gidebilirsiniz, bakarak yeni bir şey de çıkartabilirsiniz.
1. Postgres yüklenecek,
2. meetmedb adında db create edilecek
3. Aşağıdaki SQL scripti postgresql üstünden çalıştırılacak(meetmedb)
```sql
CREATE TABLE public."Meetings"
(
    id integer NOT NULL,
    name character varying(120)[] COLLATE pg_catalog."default",
    "desc" character varying(120)[] COLLATE pg_catalog."default",
    CONSTRAINT "Meetings_pkey" PRIMARY KEY (id)
)
TABLESPACE pg_default;

ALTER TABLE public."Meetings"
    OWNER to postgres;
```
4. meetme spring boot projesi clone'lanacak
5. packageler install edilecek (maven - pom.xml)
7. main'den çalıştırılacak
8. POSTMAN üstünden Controller tarafındaki görebileceğiniz endpointlere request atılarak back end in çalıştığı gözlemlenecek.
