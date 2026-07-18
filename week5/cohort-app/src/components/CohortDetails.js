import styles from "./CohortDetails.module.css";

function CohortDetails(props) {
    const cohort = props.cohort;

    return (
        <div className={styles.box}>
            <h3
                style={{
                    color:
                        cohort.status === "ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {cohort.cohortCode}
            </h3>

            <dl>
                <dt>Technology</dt>
                <dd>{cohort.technology}</dd>

                <dt>Status</dt>
                <dd>{cohort.status}</dd>

                <dt>Coach</dt>
                <dd>{cohort.coach}</dd>

                <dt>Trainer</dt>
                <dd>{cohort.trainer}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;