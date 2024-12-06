import React, {useEffect, useState} from 'react'
import {useNavigate, useParams} from "react-router-dom";
// more imports needed here

const DCListAssignedPlan = () => {

    const [assignedPlans, setAssignedPlans] = useState([]);
    const {id : projectId} = useParams();
    const [projectName, setProjectName] = useState('');

    const navigator = useNavigate();

    useEffect(() => {
        if (projectId) {
            // Insert Fetch assigned plans


            // Insert Fetch project name


            // test data to be deleted after
            // these attributes are incomplete since you can't actually have instances of an assigned plan itself,
            // it must be one of the three subclasses of assigned plan,
            // but i am leaving it like this for now to be changed later
            const dummyAssignedPlans = [
                { chopCode: 'BELL', mileage: '0.25', drawingNumber: 'BELL000.25FG_SW_1', planType: 'SW', projectId: '1' },
                { chopCode: 'BELL', mileage: '0.25', drawingNumber: 'BELL001.43FA_JP_1', planType: 'SW', projectId: '1' },
                { chopCode: 'BELL', mileage: '0.25', drawingNumber: 'BELL001.43FE_SL_1', planType: 'SW', projectId: '1' },
              ];
            const dummyProjectName = "Dummy Project";


            setAssignedPlans(dummyAssignedPlans);
            setProjectName(dummyProjectName);
        }
    }, [projectId]);

    function back() {
        navigator(`/documentcontrol/projects`);
    }

    // NOTE: the keys might need to be modified since only one is listed here but there are multiple
    return (
        <div className='container'><br />
            <h2>{projectName} Assigned Plans</h2>
            <button className="btn btn-dark mb-2" onClick={back}>Back</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Chop Code</th>
                        <th>Mileage</th>
                        <th>Drawing Number</th>
                        <th>Plan Type</th>
                        <th>Project ID</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        assignedPlans.map(assignedPlan =>
                            <tr key={assignedPlan.drawingNumber}>
                                <td>{assignedPlan.chopCode}</td>
                                <td>{assignedPlan.mileage}</td>
                                <td>{assignedPlan.drawingNumber}</td>
                                <td>{assignedPlan.planType}</td>
                                <td>{assignedPlan.projectId}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
    )
};

export default DCListAssignedPlan;