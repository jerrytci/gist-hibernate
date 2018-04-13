var remoteData = {
    "results": [
        {
            "text": "Group 1",
            "children" : [
                {
                    "id": 1,
                    "text": "Option 1.1"
                },
                {
                    "id": 2,
                    "text": "Option 1.2"
                }
            ]
        },
        {
            "text": "Group 2",
            "children" : [
                {
                    "id": 3,
                    "text": "Option 2.1"
                },
                {
                    "id": 4,
                    "text": "Option 2.2"
                }
            ]
        }
    ],
    "paginate": {
        "more": true
    }
};

var data = [
    {
        id: 5,
        text: 'bug',
        hello: '是的'
    },
    {
        id: 11,
        text: 'enhancement'
    },
    {
        id: 2,
        text: 'duplicate'
    },
    {
        id: 3,
        text: 'invalid'
    },
    {
        id: 4,
        text: 'wontfix'
    }
];

var subDataInit = [{
    id: 1,
    text: 'bug'
}];

var subData1 = [
    {
        id: 111,
        text: 'jerry'
    },
    {
        id: 2,
        text: 'chen'
    },
    {
        id: 3,
        text: '61'
    }
];

var subData2 = [
    {
        id: 4,
        text: 'jerryaaa'
    },
    {
        id: 5,
        text: 'chen.tc'
    },
    {
        id: 6,
        text: '4761'
    }
];

var subData3 = [
    {
        id: 0,
        text: 'bug',
        hello: '是的'
    },
    {
        id: 1,
        text: 'enhancement'
    }
];

var subData4 = [
    {
        id: 3,
        text: 'duplicate'
    },
    {
        id: 4,
        text: 'invalid'
    },
    {
        id: 5,
        text: 'wontfix'
    }
];

var subDatas = [
    {
        id: 5,
        text: 'bug',
        sub: [
            {
                id: 0,
                text: 'jerry'
            },
            {
                id: 1,
                text: 'chen'
            },
            {
                id: 2,
                text: '61'
            }
        ]
    },
    {
        id: 11,
        text: 'enhancement',
        sub: [
            {
                id: 0,
                text: 'jerryaaa'
            },
            {
                id: 1,
                text: 'chen.tc'
            },
            {
                id: 2,
                text: '4761'
            }
        ]
    },
    {
        id: 2,
        text: 'duplicate',
        sub: [
            {
                id: 0,
                text: 'pupu'
            },
            {
                id: 1,
                text: 'wow'
            },
            {
                id: 2,
                text: '777'
            }
        ]
    },
    {
        id: 3,
        text: 'invalid'
    },
    {
        id: 4,
        text: 'wontfix'
    }
];