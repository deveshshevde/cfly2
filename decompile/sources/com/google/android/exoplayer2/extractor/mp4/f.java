package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import fj.o;

final class f {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f15594a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    public static Format a(int i2, Format format, Metadata metadata, Metadata metadata2, o oVar) {
        if (i2 == 1) {
            if (oVar.a()) {
                format = format.a(oVar.f27384a, oVar.f27385b);
            }
            return metadata != null ? format.a(metadata) : format;
        } else if (i2 != 2 || metadata2 == null) {
            return format;
        } else {
            for (int i3 = 0; i3 < metadata2.a(); i3++) {
                Metadata.Entry a2 = metadata2.a(i3);
                if (a2 instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) a2;
                    if ("com.android.capture.fps".equals(mdtaMetadataEntry.f15511a)) {
                        format = format.a(new Metadata(mdtaMetadataEntry));
                    }
                }
            }
            return format;
        }
    }

    public static MdtaMetadataEntry a(q qVar, int i2, String str) {
        while (true) {
            int d2 = qVar.d();
            if (d2 >= i2) {
                return null;
            }
            int p2 = qVar.p();
            if (qVar.p() == 1684108385) {
                int p3 = qVar.p();
                int p4 = qVar.p();
                int i3 = p2 - 16;
                byte[] bArr = new byte[i3];
                qVar.a(bArr, 0, i3);
                return new MdtaMetadataEntry(str, bArr, p4, p3);
            }
            qVar.c(d2 + p2);
        }
    }

    public static Metadata.Entry a(q qVar) {
        int d2 = qVar.d() + qVar.p();
        int p2 = qVar.p();
        int i2 = (p2 >> 24) & 255;
        if (i2 == 169 || i2 == 253) {
            int i3 = 16777215 & p2;
            if (i3 == 6516084) {
                CommentFrame a2 = a(p2, qVar);
                qVar.c(d2);
                return a2;
            } else if (i3 == 7233901 || i3 == 7631467) {
                TextInformationFrame a3 = a(p2, "TIT2", qVar);
                qVar.c(d2);
                return a3;
            } else if (i3 == 6516589 || i3 == 7828084) {
                TextInformationFrame a4 = a(p2, "TCOM", qVar);
                qVar.c(d2);
                return a4;
            } else if (i3 == 6578553) {
                TextInformationFrame a5 = a(p2, "TDRC", qVar);
                qVar.c(d2);
                return a5;
            } else if (i3 == 4280916) {
                TextInformationFrame a6 = a(p2, "TPE1", qVar);
                qVar.c(d2);
                return a6;
            } else if (i3 == 7630703) {
                TextInformationFrame a7 = a(p2, "TSSE", qVar);
                qVar.c(d2);
                return a7;
            } else if (i3 == 6384738) {
                TextInformationFrame a8 = a(p2, "TALB", qVar);
                qVar.c(d2);
                return a8;
            } else if (i3 == 7108978) {
                TextInformationFrame a9 = a(p2, "USLT", qVar);
                qVar.c(d2);
                return a9;
            } else if (i3 == 6776174) {
                TextInformationFrame a10 = a(p2, "TCON", qVar);
                qVar.c(d2);
                return a10;
            } else if (i3 == 6779504) {
                TextInformationFrame a11 = a(p2, "TIT1", qVar);
                qVar.c(d2);
                return a11;
            }
        } else if (p2 == 1735291493) {
            try {
                return b(qVar);
            } finally {
                qVar.c(d2);
            }
        } else if (p2 == 1684632427) {
            TextInformationFrame b2 = b(p2, "TPOS", qVar);
            qVar.c(d2);
            return b2;
        } else if (p2 == 1953655662) {
            TextInformationFrame b3 = b(p2, "TRCK", qVar);
            qVar.c(d2);
            return b3;
        } else if (p2 == 1953329263) {
            Id3Frame a12 = a(p2, "TBPM", qVar, true, false);
            qVar.c(d2);
            return a12;
        } else if (p2 == 1668311404) {
            Id3Frame a13 = a(p2, "TCMP", qVar, true, true);
            qVar.c(d2);
            return a13;
        } else if (p2 == 1668249202) {
            ApicFrame c2 = c(qVar);
            qVar.c(d2);
            return c2;
        } else if (p2 == 1631670868) {
            TextInformationFrame a14 = a(p2, "TPE2", qVar);
            qVar.c(d2);
            return a14;
        } else if (p2 == 1936682605) {
            TextInformationFrame a15 = a(p2, "TSOT", qVar);
            qVar.c(d2);
            return a15;
        } else if (p2 == 1936679276) {
            TextInformationFrame a16 = a(p2, "TSO2", qVar);
            qVar.c(d2);
            return a16;
        } else if (p2 == 1936679282) {
            TextInformationFrame a17 = a(p2, "TSOA", qVar);
            qVar.c(d2);
            return a17;
        } else if (p2 == 1936679265) {
            TextInformationFrame a18 = a(p2, "TSOP", qVar);
            qVar.c(d2);
            return a18;
        } else if (p2 == 1936679791) {
            TextInformationFrame a19 = a(p2, "TSOC", qVar);
            qVar.c(d2);
            return a19;
        } else if (p2 == 1920233063) {
            Id3Frame a20 = a(p2, "ITUNESADVISORY", qVar, false, false);
            qVar.c(d2);
            return a20;
        } else if (p2 == 1885823344) {
            Id3Frame a21 = a(p2, "ITUNESGAPLESS", qVar, false, true);
            qVar.c(d2);
            return a21;
        } else if (p2 == 1936683886) {
            TextInformationFrame a22 = a(p2, "TVSHOWSORT", qVar);
            qVar.c(d2);
            return a22;
        } else if (p2 == 1953919848) {
            TextInformationFrame a23 = a(p2, "TVSHOW", qVar);
            qVar.c(d2);
            return a23;
        } else if (p2 == 757935405) {
            Id3Frame a24 = a(qVar, d2);
            qVar.c(d2);
            return a24;
        }
        String valueOf = String.valueOf(a.c(p2));
        k.a("MetadataUtil", valueOf.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf) : new String("Skipped unknown metadata entry: "));
        qVar.c(d2);
        return null;
    }

    private static CommentFrame a(int i2, q qVar) {
        int p2 = qVar.p();
        if (qVar.p() == 1684108385) {
            qVar.d(8);
            String f2 = qVar.f(p2 - 16);
            return new CommentFrame("und", f2, f2);
        }
        String valueOf = String.valueOf(a.c(i2));
        k.c("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
        return null;
    }

    private static Id3Frame a(int i2, String str, q qVar, boolean z2, boolean z3) {
        int d2 = d(qVar);
        if (z3) {
            d2 = Math.min(1, d2);
        }
        if (d2 >= 0) {
            return z2 ? new TextInformationFrame(str, (String) null, Integer.toString(d2)) : new CommentFrame("und", str, Integer.toString(d2));
        }
        String valueOf = String.valueOf(a.c(i2));
        k.c("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static Id3Frame a(q qVar, int i2) {
        String str = null;
        String str2 = null;
        int i3 = -1;
        int i4 = -1;
        while (qVar.d() < i2) {
            int d2 = qVar.d();
            int p2 = qVar.p();
            int p3 = qVar.p();
            qVar.d(4);
            if (p3 == 1835360622) {
                str = qVar.f(p2 - 12);
            } else if (p3 == 1851878757) {
                str2 = qVar.f(p2 - 12);
            } else {
                if (p3 == 1684108385) {
                    i3 = d2;
                    i4 = p2;
                }
                qVar.d(p2 - 12);
            }
        }
        if (str == null || str2 == null || i3 == -1) {
            return null;
        }
        qVar.c(i3);
        qVar.d(16);
        return new InternalFrame(str, str2, qVar.f(i4 - 16));
    }

    private static TextInformationFrame a(int i2, String str, q qVar) {
        int p2 = qVar.p();
        if (qVar.p() == 1684108385) {
            qVar.d(8);
            return new TextInformationFrame(str, (String) null, qVar.f(p2 - 16));
        }
        String valueOf = String.valueOf(a.c(i2));
        k.c("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static TextInformationFrame b(int i2, String str, q qVar) {
        int p2 = qVar.p();
        if (qVar.p() == 1684108385 && p2 >= 22) {
            qVar.d(10);
            int i3 = qVar.i();
            if (i3 > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(i3);
                String sb2 = sb.toString();
                int i4 = qVar.i();
                if (i4 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(i4);
                    sb2 = sb3.toString();
                }
                return new TextInformationFrame(str, (String) null, sb2);
            }
        }
        String valueOf2 = String.valueOf(a.c(i2));
        k.c("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame b(com.google.android.exoplayer2.util.q r3) {
        /*
            int r3 = d(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = f15594a
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + -1
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x001c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.k.c(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.f.b(com.google.android.exoplayer2.util.q):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static ApicFrame c(q qVar) {
        String str;
        int p2 = qVar.p();
        if (qVar.p() == 1684108385) {
            int b2 = a.b(qVar.p());
            String str2 = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
            if (str2 == null) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Unrecognized cover art flags: ");
                sb.append(b2);
                str = sb.toString();
            } else {
                qVar.d(4);
                int i2 = p2 - 16;
                byte[] bArr = new byte[i2];
                qVar.a(bArr, 0, i2);
                return new ApicFrame(str2, (String) null, 3, bArr);
            }
        } else {
            str = "Failed to parse cover art attribute";
        }
        k.c("MetadataUtil", str);
        return null;
    }

    private static int d(q qVar) {
        qVar.d(4);
        if (qVar.p() == 1684108385) {
            qVar.d(8);
            return qVar.h();
        }
        k.c("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
