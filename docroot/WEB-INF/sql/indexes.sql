create index IX_75FD90FE on UrlShrinker_Url (companyId, expirationDate);
create unique index IX_1E8D453F on UrlShrinker_Url (companyId, groupId, hash);
create index IX_636E2B5 on UrlShrinker_Url (companyId, groupId, hash, privateUrl, archived);
create index IX_E8270974 on UrlShrinker_Url (companyId, groupId, hash, privateUrl, protectedUrl);
create index IX_20BAACA on UrlShrinker_Url (companyId, groupId, hash, privateUrl, protectedUrl, archived);
create index IX_97A8A0B7 on UrlShrinker_Url (companyId, groupId, userId);
create index IX_15D55D9 on UrlShrinker_Url (uuid_);
create unique index IX_4E98A2F1 on UrlShrinker_Url (uuid_, groupId);