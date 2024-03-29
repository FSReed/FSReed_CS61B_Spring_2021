package gitlet;

// TD: any imports you need here

import java.io.Serializable;
import java.util.*;

/** Represents a gitlet commit object.
 *  TD: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *  It will store a "commit message", a "timestamp", the "snapshots of the files"
 *  and its "parent commit".
 *  @author FSReed
 */
public class Commit implements Serializable {
     /** TD: add instance variables here.
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit. */
    private final String message;

    /** The timestamp of this Commit. */
    private String timeStamp;

    /** The files that has been changed in this Commit.
     *  The mapping of file name -> sha1 of the blob
     */
    private final TreeMap<String, String> snapshots;

    /** The parent commit, represented using hash code */
    private final String parentCommit;

    /* Fill in the rest of this class. */

    /** The Constructor */
    public Commit(String m, String parentHash) {
        this.message = m;
        this.timeStamp = getTime();
        this.parentCommit = parentHash;
        this.snapshots = new TreeMap<>();
    }

    /** Helper Function for getting the date for this commit */
    private String getTime() {
        Date current = new Date();
        Formatter formatter = new Formatter(Locale.US);
        formatter.format("%1$ta %1$tb %1$td %1$tT %1$tY %1$tz", current);
        return formatter.toString();
    }

    public static Commit createInitialCommit() {
        Commit tmp = new Commit("initial commit", "");
        Date epoch = new Date(0);
        Formatter formatter = new Formatter(Locale.US);
        formatter.format("%1$ta %1$tb %1$td %1$tT %1$tY %1$tz", epoch);
        tmp.timeStamp = formatter.toString();
        return tmp;
    }

    public String getSha1() {
        String information = this.getMetadata();
        return Utils.sha1(information);
    }

    /** Get the metadata of the Commit */
    protected String getMetadata() {
        StringBuilder tmp = new StringBuilder(this.message
                + this.timeStamp
                + this.parentCommit);
        for (Map.Entry<String, String> entry: snapshots.entrySet()) {
            String fileName = entry.getKey();
            String blobHash = entry.getValue();
            tmp.append(fileName).append(blobHash);
        }
        return tmp.toString();
    }
    /** Get attributes */
    public String getMessage() {
        return this.message;
    }
    public String getTimeStamp() {
        return this.timeStamp;
    }
    public TreeMap<String, String> getSnapshots() {
        return this.snapshots;
    }
    public String getParentCommit() {
        return this.parentCommit;
    }

    public HashSet<String> allFiles() {
        if (this.snapshots == null) {
            return null;
        } else {
            return new HashSet<>(this.snapshots.keySet());
        }
    }
}
