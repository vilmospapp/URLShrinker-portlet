create unique index IX_72327E99 on Url (companyId, groupId, hash);
create index IX_AB3C8F on Url (companyId, groupId, hash, privateUrl, archived);
create index IX_7AC6E64E on Url (companyId, groupId, hash, privateUrl, protectedUrl);
create index IX_6E48BF24 on Url (companyId, groupId, hash, privateUrl, protectedUrl, archived);
create index IX_96E4EB91 on Url (companyId, groupId, userId);
create index IX_A962B6BF on Url (uuid_);
create unique index IX_E09AE4CB on Url (uuid_, groupId);

create unique index IX_1E8D453F on UrlShrinker_Url (companyId, groupId, hash);
create index IX_636E2B5 on UrlShrinker_Url (companyId, groupId, hash, privateUrl, archived);
create index IX_E8270974 on UrlShrinker_Url (companyId, groupId, hash, privateUrl, protectedUrl);
create index IX_20BAACA on UrlShrinker_Url (companyId, groupId, hash, privateUrl, protectedUrl, archived);
create index IX_5BD09D45 on UrlShrinker_Url (companyId, groupId, hash, private_, archived);
create index IX_11549FD4 on UrlShrinker_Url (companyId, groupId, hash, private_, protected_);
create index IX_2D78C92A on UrlShrinker_Url (companyId, groupId, hash, private_, protected_, archived);
create index IX_97A8A0B7 on UrlShrinker_Url (companyId, groupId, userId);